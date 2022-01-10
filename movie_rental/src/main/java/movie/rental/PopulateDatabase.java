package movie.rental;

import movie.rental.entity.Movie;
import movie.rental.entity.Rental;
import movie.rental.entity.User;
import movie.rental.repository.MovieRepository;
import movie.rental.repository.RentRepository;
import movie.rental.repository.UserRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

@Component
public class PopulateDatabase {

    private final MovieRepository movieRepository;
    private final RentRepository rentRepository;
    private final UserRepository userRepository;

    public PopulateDatabase(MovieRepository movieRepository, RentRepository rentRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.rentRepository = rentRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void createEntities() throws URISyntaxException, IOException {
        User user = new User();
        user.setEmail("oana.indrecan@gamil.com");
        user.setLastName("Indrecan");
        user.setFirstName("Oana");
        userRepository.save(user);

        User user2 = new User();
        user2.setEmail("markus.pataki@gmail.com");
        user2.setLastName("Pataki");
        user2.setFirstName("Markus");
        userRepository.save(user2);

        Movie movie = new Movie();
        movie.setName("Spider-Man: No Way Home");
        movie.setDirector("Jon Watts");
        movie.setType("action, adventure, fantasy");
        movie.setDescription("With Spider-Man's identity now revealed, Peter asks Doctor Strange for help. " +
                "When a spell goes wrong, dangerous foes from other worlds start to appear, forcing Peter to discover what it truly means to be Spider-Man.");
        movie.setDuration(188);
        movie.setLaunch_date("2021-12-20");
        movie.setPrice(35);
        movie.setImage(Files.readAllBytes(new ClassPathResource("images/spiderman.jpeg").getFile().toPath()));
        movieRepository.save(movie);


        Movie movie2 = new Movie();
        movie2.setName("The Lord of the Rings: The Fellowship of the Ring\n");
        movie2.setDirector("Peter Jackson");
        movie2.setType("action, adventure, drama");
        movie2.setDescription("A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One " +
                "Ring and save Middle-earth from the Dark Lord Sauron.");
        movie2.setDuration(178);
        movie2.setLaunch_date("2001-12-10");
        movie2.setPrice(30);



        movie2.setImage(Files.readAllBytes(new ClassPathResource("images/lordOfRings.jpeg").getFile().toPath()));
        movieRepository.save(movie2);


        Movie movie3 = new Movie();
        movie3.setName("Pulp Fiction");
        movie3.setDirector("Quentin Tarantino\n");
        movie3.setType("crime, drama");
        movie3.setDescription("The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and " +
                "redemption.");
        movie3.setDuration(154);
        movie3.setLaunch_date("1994-05-21");
        movie3.setPrice(38);



        movie3.setImage(Files.readAllBytes(new ClassPathResource("images/pulp-fiction.jpg").getFile().toPath()));
        movieRepository.save(movie3);

        Movie movie4 = new Movie();
        movie4.setName("Forrest Gump");
        movie4.setDirector("QRobert Zemeckis");
        movie4.setType("drama, romance");
        movie4.setDescription("The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the" +
                " perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.");
        movie4.setDuration(144);
        movie4.setLaunch_date("1994-06-23");
        movie4.setPrice(40);



        movie4.setImage(Files.readAllBytes(new ClassPathResource("images/Forrest_gump.jpg").getFile().toPath()));
        movieRepository.save(movie4);


        Movie movie5 = new Movie();
        movie5.setName("Inception");
        movie5.setDirector("Christopher Nolan");
        movie5.setType("action,adventure,sci-fi");
        movie5.setDescription("A thief who steals corporate secrets through the use of dream-sharing technology is given " +
                "the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.");
        movie5.setDuration(148);
        movie5.setLaunch_date("2010-07-08");
        movie5.setPrice(36);



        movie5.setImage(Files.readAllBytes(new ClassPathResource("images/inception.jpg").getFile().toPath()));
        movieRepository.save(movie5);



        Rental rental = new Rental();
        rental.setDays(2);
        rental.setMovie(movie);
        rental.setUser(user);
        rentRepository.save(rental);

    }

}
