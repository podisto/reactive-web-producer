package com.simba.reactivewebproducer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:ElHadjiOmar.DIONE@orange-sonatel.com">podisto</a>
 * @since 2019-06-08
 */
@RestController
@RequestMapping(value = "/persons")
@Slf4j
public class PersonController {
    public static final List<Person> persons = new ArrayList<>();
    static {
        persons.add(new Person(1, "John"));
        persons.add(new Person(2, "Jane"));
        persons.add(new Person(3, "Max"));
        persons.add(new Person(4, "Alew"));
        persons.add(new Person(5, "Aloy"));
        persons.add(new Person(6, "Sarah"));
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") int id, @RequestParam(defaultValue = "2") int delay) throws InterruptedException {
        log.trace("--- getPerson method --- ");
        Thread.sleep(delay * 1000);
        return ResponseEntity.ok(persons.stream().filter((person) -> person.getId() == id).findFirst().get());
    }*/

    @GetMapping("/{id}")
    public Mono<Person> getPerson(@PathVariable("id") int id, @RequestParam(defaultValue = "2") int delay) throws InterruptedException {
        log.trace("--- getPerson method --- ");
        Thread.sleep(delay * 1000);
        return Mono.just(persons.stream().filter((person) -> person.getId() == id).findFirst().get());
    }
}
