package com.codeup.springblog;



import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final UserRepository userDao;
    private final PostRepository postDao;
    private final PasswordEncoder encoder;

    public StartupRunner(UserRepository userDao, PostRepository postDao, PasswordEncoder encoder) {
        this.userDao = userDao;
        this.postDao = postDao;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {

        if (userDao.count() != 0) {
            return;
        }
        User user = new User();
        user.setUsername("cody");
        user.setEmail("cody@codeup.com");
        user.setPassword(encoder.encode("codeuprocks"));
        userDao.save(user);

        Post post = new Post();
        post.setTitle("Demo title");
        post.setBody("lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem ");
        post.setUser(user);
        postDao.save(post);

        Post post1 = new Post();
        post1.setTitle("Demo title");
        post1.setBody("lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem ");
        post1.setUser(user);
        postDao.save(post1);

         Post post2 = new Post();
        post2.setTitle("Demo title");
        post2.setBody("lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem ");
        post2.setUser(user);
        postDao.save(post2);

        Post post3 = new Post();
        post3.setTitle("Demo title");
        post3.setBody("lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem ");
        post3.setUser(user);
        postDao.save(post3);


    }
}
