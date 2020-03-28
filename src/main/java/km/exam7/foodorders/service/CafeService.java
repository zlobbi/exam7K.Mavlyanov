package km.exam7.foodorders.service;

import km.exam7.foodorders.dto.CafeDTO;
import km.exam7.foodorders.repository.CafeRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class CafeService {

    private final CafeRepository cafeRepository;

    public CafeService(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    public Slice<CafeDTO> findAllPlaces(Pageable pageable) {
        var slice = cafeRepository.findAll(pageable);
        return slice.map(CafeDTO::from);
    }
}
