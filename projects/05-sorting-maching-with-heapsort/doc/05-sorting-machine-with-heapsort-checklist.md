# Project 5 Checklist

Project 5 is SortingMachine with heap sort. The following information may be 
helpful in getting started:

- Estimated time to complete the project (based on 0 reviews): ???
- Link to the project description: [Project 05][project]

When your team is finished, check this list to ensure you have 
completed all the tasks for this assignment.

## Getting Started Tasks

- [ ] We have followed the recommended approach for getting started
  - [ ] We have read this document top to bottom
  - [ ] We have reviewed the project instructions for this assignment
  - [ ] We have reviewed the rubric for this assignment
  - [ ] We have considered the estimated time to complete the assignment
  - [ ] We have referred to testing resources that could help me write a systematic test plan
    - [ ] We have referred to the [QueueOnSequence lab][queue-on-sequence]
    - [ ] We have referred to the [5 Beginner Tricks for Writing Your Own Tests][5-tricks-for-testing] article

## Ongoing Tasks

- [ ] We have followed the project instructions
  - [ ] We have setup the Eclipse project according to the [project description][project]
  - [ ] We have implemented all of the private methods: 
    - [ ] We have completed `exchangeEntries()`
    - [ ] We have completed `siftDown()`
    - [ ] We have completed `heapify()`
    - [ ] We have completed `buildHeap()`
    - [ ] We have completed `createNewRep()`
  - [ ] We have implemented the no-argument constructor
  - [ ] We have implemented all of the kernel methods: 
    - [ ] We have completed `add()`
    - [ ] We have completed `changeToExtractionMode()`
    - [ ] We have completed `removeFirst()`
    - [ ] We have completed `size()`
  - [ ] We have adhered to the representation invariant listed in the `@convention` tag in our methods 
        (i.e., our methods do not modify the representation in a way that violates the convention)
  - [ ] We have adhered to the abstraction function listed in the `@correspondence` tag in our methods
        (i.e., our methods do not assume an interpretation of the representation that differs from the correspondence)
- [ ] We have developed a systematic test plan for the SortingMachine implementation (**note**: consider a "0, 1, many" approach)
  - [ ] We have tested `add()`
  - [ ] We have tested `changeToExtractionMode()`
  - [ ] We have tested `removeFirst()`
  - [ ] We have tested `size()`
  - [ ] We have tested `isInInsertionMode()`
  - [ ] We have tested `order()`
  - [ ] We have tested the no-argument constructor
- [ ] We have considered best practices
  - [ ] We have added our names in separate `@author` tags
  - [ ] We have addressed all spotbugs and checkstyle warnings
  - [ ] We have regularly committed changes to the project files using version control with good commit messages
  - [ ] We have regularly updated our local copies of the project files using version control and handled any merge conflicts

## Submission Tasks

- [ ] We have followed the submission instructions
  - [ ] We have created a zip archive of our project directory
  - [ ] We have created PDF(s) of our project file(s)
  - [ ] We have submitted the zip archive to Carmen
  - [ ] We have submitted the PDF(s) to Carmen

## Optional Tasks

- [ ] We have filled out the the [feedback form][feedback-form] for this project, rubric, and/or checklist


[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[project]: https://web.cse.ohio-state.edu/software/2231/web-sw2/assignments/projects/sorting-machine-with-heapsort/sorting-machine-with-heapsort.html
[queue-on-sequence]: https://web.cse.ohio-state.edu/software/2231/web-sw2/extras/instructions/version-control/version-control.html
[5-tricks-for-testing]: https://therenegadecoder.com/code/beginner-tricks-for-writing-your-own-unit-tests/
