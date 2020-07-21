import java.util.HashSet;
import java.util.Set;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class ValidatinData {
	@Test
	public void whenCallingMoviesEndpoint_thenReturnAllMovies() {
	 
	Set<Movie> movieSet = new HashSet<>();
	movieSet.add(new Movie(1, "movie1", "summary1"));
	movieSet.add(new Movie(2, "movie2", "summary2"));
	when(appService.getAll()).thenReturn(movieSet);
	 
	get(uri + "/movies").then()
	    .statusCode(HttpStatus.OK.value())
	    .assertThat()
	    .body("size()", is(2));
	}

}
