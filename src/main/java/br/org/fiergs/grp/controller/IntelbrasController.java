package br.org.fiergs.grp.controller;

import br.org.fiergs.grp.service.IntelbrasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class IntelbrasController {

//    String remoteHost = "https://jsonplaceholder.typicode.com";

    private IntelbrasService service;

    public IntelbrasController(IntelbrasService service) {
        this.service = service;
    }

    @GetMapping(path = "/post")
//    @PreAuthorize("hasRole('GRP_ADM[*]')")
    public Response obterUsuarioByUserID() {

        /*
        Client client = ClientBuilder.newClient();
        Response response = client.target(remoteHost).path("/posts")
                .request(MediaType.APPLICATION_JSON)
                .get();
        client.close();
        */
        Response response = service.obterUsuarioByUserID();
        return response;
    }

}
