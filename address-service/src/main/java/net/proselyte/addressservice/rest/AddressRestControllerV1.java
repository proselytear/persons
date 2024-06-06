package net.proselyte.addressservice.rest;

import lombok.RequiredArgsConstructor;
import net.proselyte.addressservice.client.PersonClient;
import net.proselyte.addressservice.dto.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/addresses")
public class AddressRestControllerV1 {

    private final PersonClient personClient;

    @GetMapping("/{addressUid}/persons")
    public ResponseEntity<List<PersonDto>> getPersonsByAddressUid(@PathVariable("addressUid") String addressUid) {
        List<PersonDto> personDtos = personClient.getPersons();
        return ResponseEntity.ok(personDtos);
    }

    @PostMapping("/exit")
    public ResponseEntity<?> exit() {
        System.exit(1);
        return ResponseEntity.ok().build();
    }
}
