import java.util.Map;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

@RunWith(SpringRunner.class)
	@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
	public class AppControllerIntegrationTest {
	 
	    @LocalServerPort
	    private int port;
	  bmbbmn
	    private String uri;
	 
	    @PostConstruct
	    public void init() {
	        uri = "http://localhost:" + port;
	    }
	    @Test
	    public void givenMovieId_whenMakingGetRequestToMovieEndpoint_thenReturnMovie() {
	     
	        Movie testMovie = new Movie(1, "movie1", "summary1");
	        when(appService.findMovie(1)).thenReturn(testMovie);
	     
	        get(uri + "/movie/" + testMovie.getId()).then()
	          .assertThat()
	          .statusCode(HttpStatus.OK.value())
	          .body("id", equalTo(testMovie.getId()))
	          .body("name", equalTo(testMovie.getName()))
	          .body("synopsis", notNullValue());
	        String responseString = get(uri + "/movie/" + testMovie.getId()).then()
	        		  .assertThat()
	        		  .statusCode(HttpStatus.OK.value())
	        		  .extract()
	        		  .asString();
	        		assertThat(responseString).isNotEmpty();
	    }
	    @Test
	    public void givenMovie_whenMakingPostRequestToMovieEndpoint_thenCorrect() {
	        Map<String, String> request = new HashMap<>();
	        request.put("id", "11");
	        request.put("name", "movie1");
	        request.put("synopsis", "summary1");
	     
	        int movieId = given().contentType("application/json")
	          .body(request)
	          .when()
	          .post(uri + "/movie")
	          .then()
	          .assertThat()
	          .statusCode(HttpStatus.CREATED.value())
	          .extract()
	          .path("id");
	        assertThat(movieId).isEqualTo(11);
	    }
		private Object notNullValue() {
			// TODO Auto-generated method stub
			return null;
		}
	}

