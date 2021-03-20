package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DogTypes {

    DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    List<String> getDogsByCountry(String country) {

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select name from dog_types where country = ?");
        ) {
            stmt.setString(1, country);
            return selectByPreparedStatement(stmt);

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select names", se);
        }
    }

    private List<String> selectByPreparedStatement(PreparedStatement stmt) {
        List<String> names = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("name");
                names.add(name.toLowerCase());
            }
            Collections.sort(names);
            return names;

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select names", se);
        }
    }
}
