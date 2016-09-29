package br.com.grupo4.mutirapp.service;

import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import br.com.grupo4.mutirapp.model.Acao;

public class BuscaCEPServiceImpl implements BuscaCEPService {

	private static BuscaCEPServiceImpl instance;

	public static BuscaCEPServiceImpl getInstance(){
		if (instance == null){
			instance = new BuscaCEPServiceImpl();
		}

		return instance;
	}

	@Override
	public void preencherEndereco(Acao acao, String cep) {
		//A conexão https exige certificados.
		byPassCertificates();
		
		try {
			String param = String.format("https://viacep.com.br/ws/%s/xml/", cep);
			URL url = new URL(param);
			Document document = getDocumento(url);
			Element root = document.getRootElement();
			Iterator<Element> i = root.elementIterator();

			while (i.hasNext()) {
				Element element = i.next();

				switch (element.getQualifiedName()) {
				case "resultado":
					if (Integer.parseInt(element.getText()) != 1) {
						return ;
					}
					break;

				case "uf":
					acao.setEndUf(element.getText());
					break;

				case "localidade":
					acao.setEndCidade(element.getText());
					break;

				case "bairro":
					acao.setEndBairro(element.getText());
					break;

				case "tipo_logradouro":
					acao.setEndLogradouroTipo(element.getText());
					break;

				case "logradouro":
					acao.setEndLogradouro(element.getText());
					break;

				default:
					//do nothing.
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			// CEP inválido ou o servidor não respondeu.
		}
	}
	
	private void byPassCertificates() {
		TrustManager[] trustAllCerts = new TrustManager[] { 
				new X509TrustManager() {     
					public java.security.cert.X509Certificate[] getAcceptedIssuers() { 
						return new X509Certificate[0];
					} 
					public void checkClientTrusted( 
							java.security.cert.X509Certificate[] certs, String authType) {
					} 
					public void checkServerTrusted( 
							java.security.cert.X509Certificate[] certs, String authType) {
					}
				} 
		}; 

		// Install the all-trusting trust manager
		try {
			SSLContext sc = SSLContext.getInstance("SSL"); 
			sc.init(null, trustAllCerts, new java.security.SecureRandom()); 
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (GeneralSecurityException e) {
		} 
		// Now you can access an https URL without having the certificate in the truststore
	}

	private Document getDocumento(URL url) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(url);
		return document;
	}

}
