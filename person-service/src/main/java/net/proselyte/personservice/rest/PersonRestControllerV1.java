package net.proselyte.personservice.rest;

import lombok.RequiredArgsConstructor;
import net.proselyte.personservice.dto.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/persons")
public class PersonRestControllerV1 {


    @GetMapping("/{uid}")
    public ResponseEntity<PersonDto> getPersonByUid(@PathVariable("uid") String uid) {
        PersonDto personDto = new PersonDto(UUID.randomUUID().toString(),
                "John",
                "Doe",
                "john.doe@mail.com");
        return ResponseEntity.ok(personDto);
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getPersons() {
        PersonDto personDto1 = new PersonDto(UUID.randomUUID().toString(),
                "John",
                "Doe",
                "john.doe@mail.com");

        PersonDto personDto2 = new PersonDto(UUID.randomUUID().toString(),
                "Mike",
                "smith",
                "mike.smith@mail.com");

        PersonDto personDto3 = new PersonDto(UUID.randomUUID().toString(),
                "Frank",
                "Jones",
                "frank.jones@mail.com");

        return ResponseEntity.ok(List.of(personDto1, personDto2, personDto3));
    }

    @PostMapping("/exit")
    public ResponseEntity<?> exit() {
        System.exit(1);
        return ResponseEntity.ok().build();
    }
}
