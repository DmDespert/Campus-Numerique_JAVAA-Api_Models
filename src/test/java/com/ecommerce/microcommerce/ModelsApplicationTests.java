package com.ecommerce.microcommerce;

import com.ecommerce.microcommerce.model.Model;
import com.ecommerce.microcommerce.dao.ModelDao;
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
    private ModelDao modelArray;

    /**
     * Ensure that endpoint /Models get Json
     * @throws Exception
     */
    @Test
    public void modelsShouldReturnAllModels() throws Exception {
        String body = this.restTemplate.getForObject("/Models", String.class);
        ObjectMapper jsonParser = new ObjectMapper();
        List<Model> model = jsonParser.readValue(body, new TypeReference<List<Model>>() {});
        assertThat(model).isEqualTo(modelArray.findAll());
    }
}