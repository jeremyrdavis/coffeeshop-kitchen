package com.redhat.quarkus.coffeeshop.kitchen.infrastructure;

import com.redhat.quarkus.coffeeshop.kitchen.Kitchen;
import com.redhat.quarkus.coffeeshop.kitchen.domain.KitchenOrder;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Path("/kitchen")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RESTResource {

    @Inject
    Kitchen kitchen;

    private Executor executor = Executors.newSingleThreadExecutor();

    @GET
    public String hello() {
        return "hello";
    }

    @POST
    @Path("/orders")
    public CompletionStage<Response> orderIn(KitchenOrder kitchenOrder) {
        return CompletableFuture.supplyAsync(() -> {
            kitchen.orderIn(kitchenOrder);
            return Response.accepted().build();
        }, executor);
    }

}