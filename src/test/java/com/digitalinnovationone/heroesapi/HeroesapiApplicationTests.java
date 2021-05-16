package com.digitalinnovationone.heroesapi;

import com.digitalinnovationone.heroesapi.document.Heroes;
import com.digitalinnovationone.heroesapi.service.HeroesService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.digitalinnovationone.heroesapi.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
class HeroesapiApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	HeroesService service;

	@Test
	public void ShouldReturnStatusOkWhenGetOneHeroById() {
		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"2")
				.exchange()
				.expectStatus().isOk()
				.expectBody();
	}

	@Test
	public void ShouldReturnNotFoundWhenGetHeroByInvalidId() {
		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"99")
				.exchange()
				.expectStatus().isNotFound();
	}

	@Test
	public void ShouldReturnCreatedWhenNewHeroSave() {
		Heroes hero = new Heroes();
		hero.setName("homem de ferro");
		hero.setUniverse("marvel");
		hero.setId("5");
		hero.setFilms(5);

		webTestClient.post().uri(HEROES_ENDPOINT_LOCAL)
				.bodyValue(hero)
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isCreated()
				.expectBody(Heroes.class);
	}

	@Test
	public void ShouldReturnAcceptedWhenDeleteHeroById() {
		Heroes hero = new Heroes();
		hero.setName("heroi junit");
		hero.setUniverse("desconhecido");
		hero.setId("15");
		hero.setFilms(1);
		service.save(hero);

		webTestClient.delete().uri(HEROES_ENDPOINT_LOCAL.concat("/{1}"),"15")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isAccepted()
				.expectBody(Void.class);
	}

}
