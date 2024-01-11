package jez;

public class Application
{
	public static String secret = "secret";

	public static void main(String[] args) throws Exception
	{
		var carteEmbarquement = new CarteEmbarquement("nom", 10, "porte 2", "10 heures");

		var serviceEnregistrement = new ServiceEnregistrement();

		System.out.println(serviceEnregistrement
				.calculerEmpreinte(serviceEnregistrement.encodeCarte(carteEmbarquement)));
		System.out.println(serviceEnregistrement.encodeCarte(carteEmbarquement));

		System.out.println(serviceEnregistrement
				.lireEtVerifier("{\"nomPassager\":\"nom\",\"numeroVol\":10,\"porteEmbarquement\":\"porte 2\",\"heureDecollage\":\"10 heures\"}",
								"EoV5lLsddLW6kludwGDmE3W5RCw2Kq0NYL0Tqd9qQUo="));
	}


}
