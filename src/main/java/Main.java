import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

import org.pieux.ibatis_demo.Post;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        System.out.println("Hello World!");

        String resource = "ibatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlMapClient sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(inputStream);

        /*try {
            sqlMapClient.startTransaction();
            System.out.println(sqlMapClient.queryForObject("getPost", 2).toString());
            sqlMapClient.commitTransaction();

        } finally {
            sqlMapClient.endTransaction();
        }*/

        List<Post> postList = null;
        try {
            sqlMapClient.startTransaction();
            postList = (List<Post>) sqlMapClient.queryForList("listPost");
            sqlMapClient.commitTransaction();

        } finally {
            sqlMapClient.endTransaction();
        }

        for(Post post:postList)
        {
            System.out.println(post.toString());
        }

        /*try {
            sqlMapClient.startTransaction();
            Post new_post = new Post();
            new_post.setTitle("new_post");
            new_post.setAuthor("new_author");
            new_post.setPublish_date(Timestamp.valueOf("2012-02-02 12:12:12"));
            new_post.setContent("new_content");
            sqlMapClient.insert("insertPost", new_post);
            sqlMapClient.commitTransaction();
        } finally {
            sqlMapClient.endTransaction();
        }*/

        /* try {
            sqlMapClient.startTransaction();
            sqlMapClient.delete("deletePost", 1);
            sqlMapClient.commitTransaction();
        } finally {
            sqlMapClient.endTransaction();
        } */

    }
}


