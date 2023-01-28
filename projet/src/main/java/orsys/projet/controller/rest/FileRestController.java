package orsys.projet.controller.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import orsys.projet.dto.FileDto;
import orsys.projet.service.FileService;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class FileRestController {
	private final FileService fileService;

	@GetMapping(value = "files/{dateDeb}/{dateFin}")
	public List<FileDto> getFilesInfo(
			@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("dateDeb") LocalDate dateDeb,
			@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("dateFin") LocalDate dateFin) {
		// TODO vérifier la session
		
		return fileService.recupererFilesInfo(dateDeb, dateFin);
	}
}
