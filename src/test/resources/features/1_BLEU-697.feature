@BLEU-702
Feature: Default

		#@BLEU-697
		Background:
		    Given the "human resource user" is logged in
		

	#*Acceptance Criteria:*
	#
	#_{color:#FF0000}1. User can suggest new idea by clicking "New idea" under Ideas page of Services module.{color}_
	#2. User can dislike the idea.
	#3. User can like the idea.
	#4. User can sort the ideas by date added.
	#5. User can sort the ideas by rating.
	#6. User should be able to create new category by clicking "New category" under Ideas page of Services module.
	#7. User can print the lists by clicking "Print" button under Lists page of Services menu.
	@BLEU-675
	Scenario: User can suggest "New Idea" under "Ideas" page of "Services" module
		When  the user clicks "Ideas" page "Services" module
		    And the user clicks New Idea button
		    And creates new idea using following information
		      | Title            | new idea         |
		      | Idea description | new idea test    |
		      | Tags             | #newIdeaTest     |
		      | Category         | Services Test |
		
		    And the user clicks Suggest New Idea
		    Then new idea should be created	

	
	@BLEU-676
	Scenario: User can like the idea
		When  the user clicks "Ideas" page "Services" module
		      And  the user clicks plus sign next to Rating
		      Then Like button should be selected	

	#*Acceptance Criteria:*
	#
	#1. User can suggest new idea by clicking "New idea" under Ideas page of Services module.
	#2. User can dislike the idea.
	#_{color:#FF0000}3. User can like the idea.{color}_
	#4. User can sort the ideas by date added.
	#5. User can sort the ideas by rating.
	#6. User should be able to create new category by clicking "New category" under Ideas page of Services module.
	#7. User can print the lists by clicking "Print" button under Lists page of Services menu.
	@BLEU-698
	Scenario: User can like the idea (negative)
		When  the user clicks "Ideas" page "Services" module
		    And  the user unclicks plus sign next to Rating
		    Then Like button should be unselected	

	#*Acceptance Criteria:*
	#
	#1. User can suggest new idea by clicking "New idea" under Ideas page of Services module.
	#_{color:#FF0000}2. User can dislike the idea.{color}_
	#3. User can like the idea.
	#4. User can sort the ideas by date added.
	#5. User can sort the ideas by rating.
	#6. User should be able to create new category by clicking "New category" under Ideas page of Services module.
	#7. User can print the lists by clicking "Print" button under Lists page of Services menu.
	@BLEU-699
	Scenario: User can dislike the idea
		When  the user clicks "Ideas" page "Services" module
		    And  the user clicks minus sign next to Rating
		    Then Dislike button should be selected	

	#1. User can suggest new idea by clicking "New idea" under Ideas page of Services module.
	#_{color:#FF0000}2. User can dislike the idea.{color}_
	#3. User can like the idea.
	#4. User can sort the ideas by date added.
	#5. User can sort the ideas by rating.
	#6. User should be able to create new category by clicking "New category" under Ideas page of Services module.
	#7. User can print the lists by clicking "Print" button under Lists page of Services menu.
	@BLEU-700
	Scenario: User can dislike the idea (negative)
		When  the user clicks "Ideas" page "Services" module
		    And  the user unclicks minus sign next to Rating
		    Then Dislike button should be unselected	

	#*Acceptance Criteria:*
	#
	#1. User can suggest new idea by clicking "New idea" under Ideas page of Services module.
	#2. User can dislike the idea.
	#3. User can like the idea.
	#_{color:#FF0000}4. User can sort the ideas by date added.{color}_
	#5. User can sort the ideas by rating.
	#6. User should be able to create new category by clicking "New category" under Ideas page of Services module.
	#7. User can print the lists by clicking "Print" button under Lists page of Services menu.
	@BLEU-701
	Scenario: User can sort the ideas by date added
		When  the user clicks "Ideas" page "Services" module
		      And  the user clicks date added button
		      Then the user should see the messages sorted by date