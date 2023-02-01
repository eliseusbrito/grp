package br.org.fiergs.grp.service;

import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
public class IntelbrasService {

    String remoteHost = "https://jsonplaceholder.typicode.com";

    String remoteHostIntelbras = "https://jsonplaceholder.typicode.com";

    public Response obterUsuarioByUserID() {
        Client client = ClientBuilder.newClient();
        Response response = client.target(remoteHost).path("/posts")
                .request(MediaType.APPLICATION_JSON)
                .get();
        client.close();
        return response;
    }

    /*
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://192.168.1.201/cgi-bin/AccessUser.cgi?action=list&UserIDList[0]=5")
          .request(MediaType.APPLICATION_JSON_TYPE)
          .header("Authorization", "Digest Auth")
          .get();
        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + response.readEntity(String.class));
        */

    public Response cadastroDeUsuario() {
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://192.168.1.201/cgi-bin/recordUpdater.cgi?action=insert&name=AccessControlCard&CardNo=AF79FCC0&CardStatus=0&CardName=AlexandreAlves&UserID=16&Password=112233&ValidDateStart=20151022%20093811&ValidDateEnd=20151222%20093811")
                .request(MediaType.TEXT_PLAIN_TYPE)
                .header("Authorization", "Digest Auth")
                .get();
        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + response.readEntity(String.class));
        client.close();
        return response;
    }

}
