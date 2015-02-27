### Dropwizard 0.8.0-rc4 hibernate performance degradation issue

Performance drop from 12k req/sec to 2.2 req/sec.

This repository contains code to demonstrate performance degradation while using hibernate when switching from 0.7.1 dropwizard version to 0.8.0-rc4.

Code is simple app which has 1 resource fetching list of DB entries via Hibernate.

Steps to reproduce:


1. `git clone git@github.com:kenota/dropwizard-perf-issue.git`
2. `cd dropwizard-perf-issue`
4. `gradle singleJar`
5. `java -jar ./build/libs/app.jar server hello-world.yml  > /dev/null`

At this point you should run some benchmark, against http://localhost:8080/video-hibernate URL. I was able to achieve 12k req/sec using 50 threads on my MacbookPro.

6. Ctrl+C to stop the running app
7. Uncomment `dropwizardVersion = "0.8.0-rc4"` line in `build.gradle` and comment out `dropwizardVersion = "0.7.1"`
8. `gradle singleJar`
9. `java -jar ./build/libs/app.jar server hello-world.yml  > /dev/null`

Run benchmark again. At this point, I was able to get only 2.2k req/sec using same 50 threads.
