package com.kim.security.wiremock;


import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * @auther: kim
 * @create: 2019-09-24 12:48
 * @description:
 */
public class MockServer {
    public static void main(String[] args) {
        configureFor(8888);
        removeAllMappings();
        stubFor(get(urlPathEqualTo("/order/1")).willReturn(aResponse().withBody("{\"id\":1}")
                .withStatus(200)));
    }
}
