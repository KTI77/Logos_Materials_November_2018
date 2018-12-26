package ua.logos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.domain.CategoryDTO;
import ua.logos.entity.CategoryEntity;
import ua.logos.repository.CategoryRepository;
import ua.logos.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO save(CategoryDTO category) {
        boolean exists = categoryRepository.existsByNameIgnoreCase(category.getName());
        if (exists) {
            return null;
        }

        CategoryEntity categoryEntity = dtoToEntityMapper(category);
        categoryRepository.save(categoryEntity);
        category.setId(categoryEntity.getId());
        return category;
    }

    @Override
    public List<CategoryDTO> findAll() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();

        for (CategoryEntity entity : categoryEntities) {
            CategoryDTO categoryDTO = entityToDTOMapper(entity);
            categoryDTOS.add(categoryDTO);
        }
        return categoryDTOS;
    }

    @Override
    public CategoryDTO findByCategoryId(Long id) {
        boolean exists = categoryRepository.existsById(id);
        if (!exists) {
            return null;
        }

        CategoryEntity categoryEntity = categoryRepository.findById(id).get();

        CategoryDTO categoryDTO = entityToDTOMapper(categoryEntity);
        return categoryDTO;
    }

    @Override
    public CategoryDTO findByCategoryName(String name) {

        return null;
    }


    private CategoryDTO entityToDTOMapper(CategoryEntity categoryEntity) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryEntity.getId());
        categoryDTO.setName(categoryEntity.getName());
        return categoryDTO;
    }

    private CategoryEntity dtoToEntityMapper(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(categoryDTO.getId());
        categoryEntity.setName(categoryDTO.getName());
        return categoryEntity;
    }
}
