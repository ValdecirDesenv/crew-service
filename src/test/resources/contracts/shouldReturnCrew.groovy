package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Should return a crew")
    request {
        method GET()
        url "/crew/1"
    }
    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(id: 1, name: "Mark", duration: 10)
    }
}