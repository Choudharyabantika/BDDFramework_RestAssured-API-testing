Feature: Validating place API

  @AddPlace
  Scenario Outline: Verify if the place is sucessfully added using Add PLace API
    Given Add place Payload with "<name>" "<language>" "<address>"
    When user calls "addPlaceAPI" with "Post" http request
    Then the API call got success with status code 200
    And "status" in responses body is "OK"
    And "scope" in responses body is "APP"
    And verify place_Id created maps to "<name>" using "getPlaceAPI"
Examples:
			|	name   | language | address |
			|Frontline house|French-IN|29, side layout, cohen 09|

	@DeletePlace
	Scenario: verify if delete place functionality is working
		Given deletePlace payload
		 When user calls "deletePlace" with "POST" http request
		 Then the API call got success with status code 200
		 And "status" in responses body is "OK"
  
