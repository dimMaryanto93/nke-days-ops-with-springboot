## Day to days Nutanix Kubernetes Engine with spring-boot

Pada training ini akan membahas daily operation pada kubernetes mulai dari

- Day 1: Design, Plan, Deploying kubernetes with Nutanix Kubernetes Engine 
- Day 2: User workloads
  - Containerize webserver (springboot)
  - Compute on Kubernetes (Deploy, Stateful, DaemonSet, Job, CronJob)
  - Storing data on Kubernetes (Local/HostPath, NFS, S3 over API)
  - Networking (ClusterIp, NodePort, Ingress, LoadBalancer)
- Day to n: add-ons operation
  - Monitoring: infra and your workload
  - Logging: export/collect logs for your workload/service

## The requirement to follow this training

Software/Tools should you install on your laptop

- [OpenJDK 17](https://openjdk.org/projects/jdk/17/) / [Oracle JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or later
- [Docker Engine/Desktop](https://www.docker.com/products/docker-desktop/)
- [git](https://git-scm.com/downloads)
- Your favorite text editor such as [vs-code](https://code.visualstudio.com/), [intelliJ IDEA](https://www.jetbrains.com/idea/download/), etc...
- Kubernetes client ([kubectl](https://kubernetes.io/docs/tasks/tools/))

Nutanix Cluster should you have to accessed

- AOS 6.5 or latest
- Prism Central 2022.6 or latest
- Enabled NKE v2.8 (Nutanix Kubernetes Engine) or latest
- Enabled NDB v2.5 (Nutanix Database) or latest
- Enabled Nutanix Object v3.6 or latest
- Enabled Nutanix files v4.4.1 or latest