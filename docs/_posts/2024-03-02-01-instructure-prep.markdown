---
title: "01 - Instructor Preparation"
date: 2024-03-02T23:08:35+07:00
catalog_key: preparation
categories:
- Nutanix
- NKE
refs: []
image_path: /resources/posts/01-instructure-prep
gist: 
downloads: []
---

Sebagai instructure, ada beberapa yang perlu disiapkan terkait environtment training dengan tajuk `Day to Days Operation with Nutanix Kubernetes Engine (NKE)` diantaranya:

- Create image profile (disk image) based on Centos 7
- Install Nexus OSS for container registry
    - Configure registry for docker image
    - Setup user auth
    - Configure insecure registry for docker engine
- Enable Nutanix Kubernetes Engine v2.8.0 or latest
    - Enable Karbon airgap
    - Create Kubernetes Cluster
- Enable Nutanix Database
    - Provision PostgreSQL 10.x database
- Enable Nutanix Files
    - Setup export folder
    - Create PVC