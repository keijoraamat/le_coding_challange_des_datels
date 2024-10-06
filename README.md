# Helm charts for the amazing Frontend and Backend

This is a helm repo for amazing apps.

## Usage

[Helm](https://helm.sh) must be installed.

Add this repo:

```bash
helm repo add coding_challange https://keijoraamat.github.io/le_coding_challange_des_datels/
```

Install app (in this example frontend is installed) with chart:

```bash
helm install frontend coding_challange/frontend
```

In case there is a need to remove the app:

```bash
helm uninstall frontend
```

In case this quick introduction to Helm was not enough head to Helm documentation - [https://helm.sh/docs/](https://helm.sh/docs/)
