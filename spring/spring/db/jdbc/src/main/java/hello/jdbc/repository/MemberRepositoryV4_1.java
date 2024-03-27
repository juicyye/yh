package hello.jdbc.repository;

import javax.sql.DataSource;

public class MemberRepositoryV4_1 {

    private final DataSource dataSource;

    public MemberRepositoryV4_1(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
