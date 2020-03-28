package km.exam7.foodorders.controller;

import km.exam7.foodorders.annotations.ApiPageable;
import km.exam7.foodorders.dto.CafeDTO;
import km.exam7.foodorders.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/places")
public class CafeController {

    private final CafeService cafeService;

    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @ApiPageable
    @RequestMapping
    public Slice<CafeDTO> getAllPlaces(@ApiIgnore Pageable pageable) {
        return cafeService.findAllPlaces(pageable);
    }
}
