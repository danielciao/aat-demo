# Automated Acceptance Testing Demo

This is a POC project for evaluating a few AAT frameworks with Geb.

Following frameworks are selected:
* Concordion
* Cucumber
* Spock

The project also takes initiative to address common additional requirements for automated testing such as running test in parallel, result reporting and taking screenshots on failure. However the amount of work required to fully fulfil those requirements may differ from framework to framework.

For instance, Concordion tests is running in sequence in this project (in order to make sure specification links are highlighted) but there are maven plugins available to convert them into running in parallel. Also additional work is needed to setup Spock report to show screenshots and correct specification wording where 'where' block is used.

Also note that **this project comes with a packaged Chrome driver executable** under *test/resources*.
