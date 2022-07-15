# scope
------------
# ApplicationScoped
There is a UserService class annotated with @ApplicationScoped
	In the service class have a static List of User that acts like a database/datastore.
	Also, there are create, update, get, getAll, delete methods to manipulte the user list.
3. There are UserConntroller class where I used @Inject to inject the UserService class.
 	and there has a use of @GET, @POST, @PUT, @DELETE annotations for the apis.
