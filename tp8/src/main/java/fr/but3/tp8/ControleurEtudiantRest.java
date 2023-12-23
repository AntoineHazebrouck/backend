package fr.but3.tp8;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class ControleurEtudiantRest {
	private final EtudiantsRepository etudiantsRepository;

	public ControleurEtudiantRest(EtudiantsRepository etudiantsRepository) {
		this.etudiantsRepository = etudiantsRepository;
	}

	@GetMapping(path = "/etudiants", produces = { "application/xml",
			"application/json" }, consumes = { "application/xml",
					"application/json" })
	public Iterable<Etudiant> getEtudiants() {
		return etudiantsRepository.findAll();
	}

	@GetMapping(path = "/etudiants/{id}", produces = { "application/xml",
			"application/json" }, consumes = { "application/xml",
					"application/json" })
	public Optional<Etudiant> getEtudiant(@PathVariable("id") Integer id) {
		return etudiantsRepository.findById(id);
	}

	@GetMapping(path = "/etudiants/select", produces = { "application/xml",
			"application/json" }, consumes = { "application/xml",
					"application/json" })
	public Iterable<Etudiant> getEtudiantByGroup(@RequestParam("groupe") String groupe) {
		return etudiantsRepository.findByGroupeOrderByNom(groupe);
	}

	@PostMapping(path = "/etudiants", produces = { "application/xml",
			"application/json" }, consumes = { "application/xml",
					"application/json" })
	public Etudiant postEtudiants(@Valid @RequestBody Etudiant etudiant) {
		// etudiant.
		return etudiantsRepository.save(etudiant);
	}

	@PutMapping(path = "/etudiants", produces = { "application/xml",
			"application/json" }, consumes = { "application/xml",
					"application/json" })
	public Etudiant putEtudiant(@RequestBody Etudiant etudiant) {
		return etudiantsRepository.save(etudiant);
	}

	@PatchMapping(path = "/etudiants/{id}", produces = { "application/xml",
			"application/json" }, consumes = { "application/xml",
					"application/json" })
	public ResponseEntity<Etudiant> patchEtudiant(@PathVariable("id") Integer id, @RequestBody Etudiant etudiant) {
		Optional<Etudiant> etudiantFromDB = etudiantsRepository.findById(id);

		if (etudiantFromDB.isPresent()) {
			var patchEtu = etudiantFromDB.get();
			if (etudiant.getAge() != null) {
				patchEtu.setAge(etudiant.getAge());
			}
			if (etudiant.getGroupe() != null) {
				patchEtu.setGroupe(etudiant.getGroupe());
			}
			if (etudiant.getNom() != null) {
				patchEtu.setNom(etudiant.getNom());
			}
			if (etudiant.getPrenom() != null) {
				patchEtu.setPrenom(etudiant.getPrenom());
			}

			return ResponseEntity.ofNullable(etudiantsRepository.save(patchEtu));

		} else {
			return new ResponseEntity<>(HttpStatusCode.valueOf(404));
		}

	}

	@DeleteMapping(path = "/etudiants/{id}", produces = { "application/xml",
			"application/json" }, consumes = { "application/xml",
					"application/json" })
	public Optional<Etudiant> deleteEtudiant(@PathVariable Integer id) {
		var etu = etudiantsRepository.findById(id);
		etudiantsRepository.deleteById(id);
		return etu;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
			MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}
