package com.alpscron.boundary;

import com.alpscron.entity.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ProductResource {

   public static List<Product> products = new ArrayList<>();

    @GET
    public List<Product> getAllProduct(){
        return products;

    }

    @POST
    public Response addProduct(Product product){
        products.add(product);
        return Response.ok(product).build();
    }

    @PUT
    @Path("{id}/{brand}")
    public Response updateProduct(@PathParam("id") int id, @PathParam("brand") String brand){
        products = products.stream().map(product->{
            if(product.getProductId() == id){
                product.setProductBrand(brand);
            }
            return product;
        }).collect(Collectors.toList());
        return Response.ok(products).build();
    }




}
