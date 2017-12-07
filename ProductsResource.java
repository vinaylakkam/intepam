import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

@Path("/products")
public class ProductsResource {

	@Autowired
	private ProductsService productsSvc;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducts(@QueryParam("category") String category) {
		Products products = productsSvc.getProductsByCategory(category);
		if (products != null) {
			SortUtil.sortProductsByPopularity(products.getItems());
			return Response.ok(products).build();
		} else {
			ErrorMessage errorMessage = new ErrorMessage(404, "No Products for the category");
			return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
		}
	}

}
