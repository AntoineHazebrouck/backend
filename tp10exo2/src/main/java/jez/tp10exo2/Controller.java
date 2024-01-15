package jez.tp10exo2;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller
{
	Map<Integer, Flight> flights;

	public Controller()
	{
		this.flights = new HashMap<>();
		flights.put(1, new Flight(1, "micheal", List.of("passenger 1", "passenger 2")));
	}

	@GetMapping("/me")
	public Principal me(Principal principal)
	{
		return principal;
	}

	@PostMapping("/board/{flightId}")
	public Flight board(Principal principal, @PathVariable Integer flightId,
			@RequestParam Optional<String> pilot, @RequestParam Optional<List<String>> passengers)
	{
		if (flights.containsKey(flightId))
		{
			return flights.get(flightId);
		} else
		{
			flights.put(flightId,
						new Flight(
								flightId,
								pilot.orElseGet(() -> {

									var JwtPrincipal = (JwtAuthenticationToken) principal;
									boolean isPilot = JwtPrincipal.getAuthorities()
											.stream()
											.anyMatch(authority -> {
												return authority.getAuthority()
														.contains("pilot");
											});

									if (isPilot)
									{
										return JwtPrincipal.getName();
									} else
									{
										throw new IllegalArgumentException();
									}

								}),
								passengers.orElseGet(() -> {
									OAuth2AuthenticationToken token =
											(OAuth2AuthenticationToken) principal;
									OidcUser user = (OidcUser) token.getPrincipal();

									boolean isGitlabUnivLilleUser = user.getAuthorities()
											.stream()
											.anyMatch(authority -> {
												return authority.getAuthority()
														.contains("OIDC_USER");
											});

									if (isGitlabUnivLilleUser)
									{
										return List.of(user.getUserInfo()
												.getFullName());
									} else
									{
										throw new IllegalArgumentException();
									}
								})));
			return flights.get(flightId);
		}
	}

}
