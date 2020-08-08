package com.glancebar.webfluxtutorial;


import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.Slf4JLoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RestController
public class WebFluxController {

    private final InternalLogger log = Slf4JLoggerFactory.getInstance(WebFluxController.class);

    private String createStr() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
        return "some string";
    }


    @GetMapping("/normal")
    private String getByNormal() {
        log.info("getByNormal start");
        var result = createStr();
        log.info("getByNormal end");
        return result;
    }

    @GetMapping("/webflux")
    private Mono<?> getByWebFlux() {
        log.info("getByWebFlux start");
        Mono<?> result = Mono.fromSupplier(this::createStr);
        log.info("getByWebFlux end");
        return result;
    }

    @GetMapping(value = "/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    private Flux<String> flux() {
        Flux<String> result = Flux.fromStream(IntStream.range(1, 5).mapToObj(i -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "flux data -- " + i;
        }));
        return result;
    }

}
