# A showcase repo of extraordinary Java app and infrastructure for it

This is a monorepo for frontend, backend, helm packages and CI/CD pipelines for building-testing application and deploying helm charts. For easy local development docker compose file is also provided. 

## Application overview

The Java web application is released in dockerimages. Also Helm charts are provided to install and maintain the application in Kubernetes.

## Getting started

Installing is simple as the app itself is simple. Not many moving parts.

### Prerequesities

- Kubernetes cluster (with ingress controller installed)
- Helm

By default nginx ingress is enabled in the helm charts. If some other ingress controller is used please override the values - look at how to use custom values

## Developing further

Every components directory has its own specific readme to help getting starting.

---

## How-To

Section about how to do things.

### Install the Application via Helm

Add Helm repository

```bash
helm repo add coding_challange https://keijoraamat.github.io/le_coding_challange_des_datels/
```

Install app (in this example frontend is installed) with chart:

```bash
helm install frontend coding_challange/frontend
```

### Overwrite default values

There are 2 options. One is to write custom values into a yaml file. Second option is to use *--set* flag. 

**NB!** The default values need no change if myapp.local is added to */etc/hosts* file to point to 127.0.0.1

See more in Helm documentation: [https://helm.sh/docs/intro/using_helm/#customizing-the-chart-before-installing](https://helm.sh/docs/intro/using_helm/#customizing-the-chart-before-installing)

### Install nginx ingress controller

Add Helm repository
```bash
helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm repo update
```
Install the controller
```bash
helm install my-ingress ingress-nginx/ingress-nginx --set controller.publishService.enabled=true
```

### Remove installed application

In case there is a need to remove the app:

```bash
helm uninstall frontend
```

## Contributing
Feel free to submit issues or pull requests if you find any bugs or have suggestions for improvements.

## License
This project is licensed under the MIT License.
