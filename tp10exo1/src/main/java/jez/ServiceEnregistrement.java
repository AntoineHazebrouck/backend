package jez;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ServiceEnregistrement
{
	private final ObjectMapper objectMapper;

	public ServiceEnregistrement()
	{
		this.objectMapper = new ObjectMapper();
	}

	public String encodeCarte(CarteEmbarquement carteEmbarquement) throws JsonProcessingException
	{
		return objectMapper.writeValueAsString(carteEmbarquement);
	}

	public CarteEmbarquement decodeCarte(String json)
			throws JsonMappingException, JsonProcessingException
	{
		return objectMapper.readValue(json, CarteEmbarquement.class);
	}

	public String calculerEmpreinte(String json) throws NoSuchAlgorithmException
	{
		MessageDigest digest = MessageDigest.getInstance("SHA-256");

		String jsonPlusSecret = json + Application.secret;
		byte[] encodedhash = digest.digest(
											jsonPlusSecret.getBytes(StandardCharsets.UTF_8));

		byte[] hashedInBase64 = Base64.getEncoder()
				.encode(encodedhash);

		return new String(hashedInBase64);
	}

	public CarteEmbarquement lireEtVerifier(String json, String empreinte)
			throws JsonMappingException, JsonProcessingException, NoSuchAlgorithmException
	{
		if (calculerEmpreinte(json).equals(empreinte))
		{
			return decodeCarte(json);
		} else
		{
			throw new IllegalArgumentException();
		}
	}
}
