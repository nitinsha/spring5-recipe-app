package guru.springframework.services;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;

/**
 * Created by jt on 7/3/17.
 */
@Slf4j
@Service
public class ImageServiceImpl implements ImageService {
	
	private final RecipeRepository recipeRepository;
	
	
    public ImageServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}


	@Override
    public void saveImageFile(Long recipeId, MultipartFile file) {

    	Recipe recipe = recipeRepository.findById(recipeId).get(); 
    try {
		Byte[] imageObject = new Byte[file.getBytes().length];
		
		int i=0;
		for(byte b:file.getBytes()) {
			imageObject[i++] = b;
		}
		recipe.setImage(imageObject);
		recipeRepository.save(recipe);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    }
}
