package study.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.dto.MemberDto;
import study.querydsl.dto.QMemberDto;
import study.querydsl.entity.Member;
import study.querydsl.entity.QMember;
import study.querydsl.entity.QTeam;
import study.querydsl.entity.Team;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static study.querydsl.entity.QMember.*;
import static study.querydsl.entity.QTeam.*;

@SpringBootTest
@Transactional
public class QuerydslBasicTest {

    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;

    @BeforeEach
    public void before(){
        queryFactory =  new JPAQueryFactory(em);
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);
        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
    }

    @Test
    public void startJPQL(){
        // member1을 찾아라
        Member findMember = em.createQuery("select m from Member m where m.username =  :username", Member.class)
                .setParameter("username", "member1")
                .getSingleResult();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    public void startQuerydsl(){

        Member findMember = queryFactory.select(member).from(member).where(member.username.eq("member1"))
                .fetchOne();
        assertThat(findMember.getUsername()).isEqualTo("member1");

    }

    @Test
    public void search(){

        Member findMember = queryFactory.selectFrom(member)
                .where(member.username.eq("member1").and(member.age.eq(10)))
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    public void searchAndParam(){
        queryFactory.selectFrom(member)
                .where(member.username.eq("member1"), member.age.eq(10)).fetchOne();
    }

    @Test
    public void sort(){
        queryFactory.selectFrom(member)
                .orderBy(member.age.desc(), member.username.asc().nullsLast()).fetch();
    }

    @Test
    public void paging1(){
        queryFactory.selectFrom(member)
                .orderBy(member.username.desc())
                .offset(1)
                .limit(2)
                .fetch();
    }

    @Test
    public void aggregation(){
        List<Tuple> result = queryFactory.select(member.count(), member.age.sum(), member.age.avg())
                .from(member).fetch();

        Tuple tuple = result.get(0);
        System.out.println("tuple = " + tuple);
        System.out.println("tuple.getClass() = " + tuple.getClass());
        assertThat(tuple.get(member.count())).isEqualTo(4);
    }

    @Test
    public void group(){
        List<Tuple> result = queryFactory.select(team.name, member.age.avg()).from(member).join(member.team, team)
                .groupBy(team.name)
                .fetch();

        Tuple tuple = result.get(0);
        Tuple tuple2 = result.get(1);

        assertThat(tuple.get(team.name)).isEqualTo("teamA");
        assertThat(tuple.get(member.age.avg())).isEqualTo(15);

        assertThat(tuple2.get(team.name)).isEqualTo("teamB");
        assertThat(tuple2.get(member.age.avg())).isEqualTo(35);
    }

    /**
     * 회원과 팀을 조인하면서 팀 이름이 teamA인 티만 조인, 회원은 모두 조회
     */
    @Test
    public void join_on_filtering(){
        List<Tuple> result = queryFactory.select(member, team).from(member).leftJoin(member.team, team).on(team.name.eq("teamA")).fetch();

        Tuple tuple = result.get(0);
        tuple.get(member.username);
    }

    @Test
    public void join_on_no_relation(){
        List<Tuple> result = queryFactory
                .select(member, team)
                .from(member)
                .leftJoin(team).on(member.username.eq(team.name))
                .fetch();

        Tuple tuple = result.get(0);
        tuple.get(member.username);
    }

    @Test
    public void fetchJoinNo(){
        em.flush();
        em.clear();

        queryFactory.select(member)
                .from(member)
                .join(member.team, team).fetchJoin()
                .where(member.username.eq("member1"))
                .fetch();
    }

    @Test
    public void subQuery(){
        QMember ms = new QMember("ms");
        List<Member> result = queryFactory.selectFrom(member)
                .where(member.age.eq(
                        JPAExpressions.select(ms.age.max())
                                .from(ms)

                )).fetch();

        assertThat(result).extracting("age").contains(40);


    }

    @Test
    public void subQueryGoe(){
        QMember ms = new QMember("ms");
        List<Member> result = queryFactory.selectFrom(member)
                .where(member.age.goe(
                        JPAExpressions.select(ms.age.avg())
                                .from(ms)

                )).fetch();

        assertThat(result).extracting("age").contains(40);
    }

    @Test
    public void basicCase(){
        queryFactory.select(member.age.when(10).then("하이").otherwise("뭐요"))
                .from(member)
                .fetch();
    }

    @Test
    public void constant(){
        List<Tuple> result = queryFactory.select(member.username, Expressions.constant("A"))
                .from(member)
                .fetch();

        for (Tuple tuple : result) {
            System.out.println("tuple = " + tuple);
        }
    }

    @Test
    public void concat(){
        List<String> result = queryFactory.select(member.username.concat("_").concat(member.age
                        .stringValue()))
                .from(member)
                .where(member.username.eq("member1"))
                .fetch();

        for (String s : result) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void simpleProjection(){
        List<String> fetch = queryFactory.select(member.username)
                .from(member)
                .fetch();


    }

    @Test
    public void tupleProjection(){
        List<Tuple> fetch = queryFactory.select(member.username, member.age)
                .from(member)
                .fetch();

        for (Tuple tuple : fetch) {
            String username = tuple.get(member.username);
            Integer age = tuple.get(member.age);
            System.out.println("age = " + age);
            System.out.println("username = " + username);
        }
    }


    @Test
    public void findDtoBySetter(){
        queryFactory.select(Projections.bean(
                MemberDto.class, member.username,member.age))
                .from(member)
                .fetch();
    }

    @Test
    public void findDtoByField(){
        queryFactory.select(Projections.fields(
                        MemberDto.class, member.username,member.age))
                .from(member)
                .fetch();
    }

    @Test
    public void findDtoByConstructor(){
        queryFactory.select(Projections.constructor(
                        MemberDto.class, member.username,member.age))
                .from(member)
                .fetch();
    }

    @Test
    public void findDtoByQueryProjection(){
        List<MemberDto> result = queryFactory.select(new QMemberDto(member.username, member.age))
                .from(member).fetch();
    }

    @Test
    public void dynamicQuery_BooleanBuilder(){
        String usernameParam = "member1";
        Integer ageParam = 10;

        List<Member> result = searchMember1(usernameParam, ageParam);

    }

    private List<Member> searchMember1(String usernameCond, Integer ageCond) {
        BooleanBuilder builder = new BooleanBuilder();
        if (usernameCond != null) {
            builder.and(member.username.eq(usernameCond));
        }
        if (ageCond != null) {
            builder.and(member.age.eq(ageCond));
        }
        List<Member> result = queryFactory.selectFrom(member).where(builder).fetch();
        return result;


    }

    @Test
    public void dynamicQuery_WhereParam(){
        String usernameParam = "member1";
        Integer ageParam = 10;

        List<Member> result = searchMember2(usernameParam, ageParam);
    }

    private List<Member> searchMember2(String usernameCond, Integer ageCond) {
        return queryFactory.selectFrom(member)
                .where(usernameEq(usernameCond), ageEq(ageCond))
                .fetch();
    }


    private Predicate usernameEq(String usernameCond) {
        if (usernameCond == null) {
           return null;}
        return member.username.eq(usernameCond);
    }
    private Predicate ageEq(Integer ageCond) {
        if (ageCond == null) {
            return null;}
        return member.age.eq(ageCond);
    }



}
