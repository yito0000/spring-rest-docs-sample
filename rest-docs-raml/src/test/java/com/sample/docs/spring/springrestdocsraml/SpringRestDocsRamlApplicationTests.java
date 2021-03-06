package com.sample.docs.spring.springrestdocsraml;

import com.epages.restdocs.raml.RamlResourceSnippetParameters;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.docs.spring.springrestdocsraml.dto.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.epages.restdocs.raml.RamlResourceDocumentation.ramlResource;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
public class SpringRestDocsRamlApplicationTests {

	private MockMvc mockMvc;

	private ObjectMapper mapper;

	@BeforeEach
	public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(documentationConfiguration(restDocumentation)).build();
		this.mapper = new ObjectMapper();
	}

	@Test
	public void getItemTest() throws Exception {
		this.mockMvc.perform(get("/item/{id}", "001"))
				.andExpect(status().isOk())
				.andDo(document("get item by id",
						ramlResource(RamlResourceSnippetParameters.builder()
								.description("IDに紐づく商品を取得する")
								.pathParameters(parameterWithName("id").description("商品ID"))
								.responseFields(
										fieldWithPath("id").description("商品ID").type(JsonFieldType.STRING),
										fieldWithPath("name").description("商品名").type(JsonFieldType.STRING),
										fieldWithPath("dateTime").description("更新日時").type(JsonFieldType.VARIES)
								).build())
				));
	}

	@Test
	public void getItemListTest() throws Exception {
		this.mockMvc.perform(get("/item/list"))
				.andExpect(status().isOk())
				.andDo(document("get item list",
						ramlResource(RamlResourceSnippetParameters.builder()
								.description("商品一覧を取得する")
								.responseFields(
										fieldWithPath("[].id").description("商品ID").type(JsonFieldType.STRING),
										fieldWithPath("[].name").description("商品名").type(JsonFieldType.STRING),
										fieldWithPath("[].dateTime").description("更新日時").type(JsonFieldType.VARIES)
								).build())
				));
	}

	@Test
	public void postItemTest() throws Exception {
		this.mockMvc.perform(post("/item")
				.content(mapper.writeValueAsString(Item.builder()
				.id("0001")
				.name("name").build()))
		.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(document("post item",
						ramlResource(RamlResourceSnippetParameters.builder()
								.description("商品を登録する")
								.responseFields(
										fieldWithPath("id").description("商品ID").type(JsonFieldType.STRING),
										fieldWithPath("name").description("商品名").type(JsonFieldType.STRING),
										fieldWithPath("dateTime").description("更新日時").type(JsonFieldType.VARIES)
								).build())
				));
	}

}
