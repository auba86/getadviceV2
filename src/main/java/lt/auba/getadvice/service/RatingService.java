package lt.auba.getadvice.service;

import lt.auba.getadvice.model.Rating;
import lt.auba.getadvice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public void saveRating(Rating rating) {
        ratingRepository.save(rating);
    }
}
