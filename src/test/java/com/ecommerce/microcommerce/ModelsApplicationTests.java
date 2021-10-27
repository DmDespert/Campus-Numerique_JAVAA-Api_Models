package com.ecommerce.microcommerce;

import com.ecommerce.microcommerce.dao.ModelDao;
import com.ecommerce.microcommerce.model.Model;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ModelsApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ModelDao models;

    /**
     * Ensure that endpoint /Models get Json
     * GET METHOD
     * @throws Exception
     */
    @Test
    public void modelsShouldReturnAllModels() throws Exception {
        String body = this.restTemplate.getForObject("/Models", String.class);
        ObjectMapper jsonParser = new ObjectMapper();
        List<Model> model = jsonParser.readValue(body, new TypeReference<List<Model>>() {});
        assertThat(model).isEqualTo(models.findAll());
    }

    /**
     * Ensure that endpoint /Models/id return specified Model
     * GET METHOD
     * @throws Exception
     */
    @Test
    public void modelShouldReturnOneModelById() throws Exception {
        Model body = this.restTemplate.getForObject("/Models/1", Model.class);
        assertThat(body).isEqualTo(models.findById(1));
    }

    /**
     * Ensure that endpoint /Models add specified Model
     * POST METHOD
     * @throws Exception
     */
    @Test
    public void modelShouldBeAddToArray() throws Exception {
        Model newModel = new Model(4, "Corsa");
        this.restTemplate.postForObject("/Models", newModel, String.class);
        assertThat(newModel).isEqualTo(models.findById(4));
    }

    /**
     * Ensure that endpoint /Models/id update specified Model
     * PUT METHOD
     * @throws Exception
     */
    @Test
    public void modelByIdShouldBeUpdate() throws Exception {
        Model updateModel = models.findById(1);
        updateModel.setModel("Corsa");
        this.restTemplate.put("/Models/1", updateModel);
        assertThat(models.findById(1)).isEqualTo(updateModel);
    }

    /**
     * Ensure that endpoint /Models/id delete specified Model
     * DELETE METHOD
     * @throws Exception
     */
    @Test
    public void modelShouldBeDeletedById() throws Exception {
        this.restTemplate.delete("/Models/1", Model.class);
        assertThat(models.findById(1)).isNull();
    }
}