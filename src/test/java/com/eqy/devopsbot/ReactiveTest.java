package com.eqy.devopsbot;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-05-07 16:54
 */
public class ReactiveTest {

    @Test
    void testFlux() throws Exception {
        Flux.just("Hello", "World").subscribe(System.out::println);
        Flux.range(1, 25).buffer(10).subscribe(System.out::println);
        Flux.range(1, 5).window(2).toIterable().forEach(w -> {
            w.subscribe(System.out::println);
            System.out.println("-------");
        });
    }

    @Test
    void testMono() throws Exception {
        Mono.justOrEmpty(Optional.of("Hello World"))
                .subscribe(System.out::println);
    }

    @Test
    void test() throws Exception {
        Flux.just(1, 2, 3, 4, 5).flatMap(Mono::just).subscribe(System.out::println);
    }
}
