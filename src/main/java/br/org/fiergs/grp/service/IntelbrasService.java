package br.org.fiergs.grp.service;

import br.org.fiergs.grp.entity.Diretor;
import br.org.fiergs.grp.entity.Face;
import br.org.fiergs.grp.utils.StringFormatter;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Base64;
import java.util.List;

@Service
public class IntelbrasService {

    @Value("${intelbras.remoteHost}")
    String remoteHostIntelbras;

    @Value("${intelbras.username}")
    String username = "admin";

    @Value("${intelbras.passwordAdmin}")
    String passwordAdmin = "ss5530AD";

    @Value("${intelbras.password}")
    String password;

    private DiretorService diretorService;

    private StringFormatter stringFormatter;

    public IntelbrasService(DiretorService diretorService, StringFormatter stringFormatter) {
        this.diretorService = diretorService;
        this.stringFormatter = stringFormatter;
    }

    public String getFirmware() {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        Credentials credentials = new UsernamePasswordCredentials(username, passwordAdmin);
        credentialsProvider.setCredentials(AuthScope.ANY, credentials);
        CloseableHttpClient client = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build();
        String firmware = "";
        try {
            HttpGet request = new HttpGet(remoteHostIntelbras + "/magicBox.cgi?action=getSoftwareVersion");
            CloseableHttpResponse response = client.execute(request);
            firmware = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return firmware;
    }

    public String obterTodosUsuarios() {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        Credentials credentials = new UsernamePasswordCredentials(username, passwordAdmin);
        credentialsProvider.setCredentials(AuthScope.ANY, credentials);
        CloseableHttpClient client = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build();
        String usuarios = "";
        try {
            HttpGet request = new HttpGet(remoteHostIntelbras + "/recordFinder.cgi?action=doSeekFind&name=AccessControlCard&count=4300");
            CloseableHttpResponse response = client.execute(request);
            usuarios = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    /*
      public Response cadastroDeUsuario() {
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://10.100.82.153/cgi-bin/recordUpdater.cgi?action=insert&name=AccessControlCard&CardNo=AF79FCC0&CardStatus=0&CardName=AlexandreAlves&UserID=16&Password=112233&ValidDateStart=20151022%20093811&ValidDateEnd=20151222%20093811")
            .request(MediaType.TEXT_PLAIN_TYPE)
            .header("Authorization", "Digest Auth")
            .get();
        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + response.readEntity(String.class));
        client.close();
        return response;
      }
    */
    public String cadastroUsuario(Long idDiretor) throws ParseException {
        Diretor diretor = diretorService.findDiretorById(idDiretor).orElseThrow();
        String nomeDiretor = stringFormatter.removeAcentuacao(diretor.getNome());
        String cardNo = "BF79FC12";
        String cardStatus = "0";
        String cardName = stringFormatter.removeEspacos(nomeDiretor);
        Long userLongID = diretor.getId();
        Long userIdNew = userLongID + 7;
        String userID = userIdNew.toString();
        String validDateStart = stringFormatter.formatDate(diretor.getValidDateStart().toString());
        String validDateEnd = stringFormatter.formatDate(diretor.getValidDateEnd().toString());
        String path = "/recordUpdater.cgi?action=insert&name=AccessControlCard&CardNo=" + cardNo + "&CardStatus=" + cardStatus + "&CardName=" + cardName + "&UserID=" + userID + "&Password=" + password + "&ValidDateStart=" + validDateStart + "&ValidDateEnd=" + validDateEnd;

        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        Credentials credentials = new UsernamePasswordCredentials(username, passwordAdmin);
        credentialsProvider.setCredentials(AuthScope.ANY, credentials);
        CloseableHttpClient client = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build();

        String usuarios = "";
        try {
//      HttpGet request = new HttpGet(remoteHostIntelbras + "/recordUpdater.cgi?action=insert&name=AccessControlCard&CardNo=AF79FCC1&CardStatus=0&CardName=Jocemar&UserID=5&Password=112233&ValidDateStart=20151022%20093811&ValidDateEnd=20151222%20093811");
            HttpGet request = new HttpGet(remoteHostIntelbras + path);
            CloseableHttpResponse response = client.execute(request);
            usuarios = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public String cadastroFotoUsuario(List<Face> payload) throws UnsupportedEncodingException {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        Credentials credentials = new UsernamePasswordCredentials(username, passwordAdmin);
        credentialsProvider.setCredentials(AuthScope.ANY, credentials);
        CloseableHttpClient client = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build();
        String faceList = "";
        StringEntity entity = new StringEntity(payload.toString());
        try {
            HttpPost request = new HttpPost(remoteHostIntelbras + "/AccessFace.cgi?action=insertMulti");
            request.setEntity(entity);
            request.setHeader("Content-Type", "application/json");
            CloseableHttpResponse response = client.execute(request);
            faceList = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return faceList;
    }

    public String registrosAcesso(String timestampInicio, String timestampFinal) throws UnsupportedEncodingException {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        Credentials credentials = new UsernamePasswordCredentials(username, passwordAdmin);
        credentialsProvider.setCredentials(AuthScope.ANY, credentials);
        CloseableHttpClient client = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build();
        String acessos = "";
        try {
            HttpGet request = new HttpGet(remoteHostIntelbras + "/recordFinder.cgi?action=find&name=AccessControlCardRec&StartTime=" + timestampInicio + "&EndTime=" + timestampFinal);
            CloseableHttpResponse response = client.execute(request);
            acessos = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acessos;
    }

    public void imagemAcessoDownload(String fileName) throws IOException {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        Credentials credentials = new UsernamePasswordCredentials(username, passwordAdmin);
        credentialsProvider.setCredentials(AuthScope.ANY, credentials);
        CloseableHttpClient client = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build();
        try {
            HttpGet request = new HttpGet(remoteHostIntelbras + "/FileManager.cgi?action=downloadFile&fileName=/mnt/appdata1/userpic/SnapShot/" + fileName);
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream inputStream = entity.getContent();
                try {
                    OutputStream outputStream = new FileOutputStream(new File(fileName + ".jpg"));
                    try {
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                        }
                        outputStream.flush();
                    } finally {
                        outputStream.close();
                    }
                } finally {
                    inputStream.close();
                }
            }
        } finally {
            client.close();
        }
    }

    public String imagemAcesso(String fileName) throws IOException {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        Credentials credentials = new UsernamePasswordCredentials(username, passwordAdmin);
        credentialsProvider.setCredentials(AuthScope.ANY, credentials);
        CloseableHttpClient client = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build();
        try {
            HttpGet request = new HttpGet(remoteHostIntelbras + "/FileManager.cgi?action=downloadFile&fileName=/mnt/appdata1/userpic/SnapShot/" + fileName);
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream inputStream = entity.getContent();
                try {
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    try {
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                        }
                        outputStream.flush();
                    } finally {
                        outputStream.close();
                    }
                    return Base64.getEncoder().encodeToString(outputStream.toByteArray());
                } finally {
                    inputStream.close();
                }
            }
        } finally {
            client.close();
        }
        return null;
    }

}
