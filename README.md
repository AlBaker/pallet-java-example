# pallet-java-example

A pallet project to illustrate the basics of configuring VMFest, using Pallet specs, and installing a Java crate.

See in line source code comments for instuction on the various components of [Pallet](http://palletops.com/).

This project uses [Pallet-Vmfest](https://github.com/pallet/pallet-vmfest) as the Pallet compute service, i.e. the IaaS cloud provider.

## Usage

Follow the instructions for pallet-vmfest and make sure you have ~/.vmfest/models/ubuntu... configured.

```pallet-vmfest``` can always use web services to speak with VirtualBox, no matter the operating system.

1. Turn off auth (only needs to be done once)
  ```bash
  $ VBoxManage setproperty websrvauthlibrary null
  ```

2. Start VirtualBox listening
  ```shell
  $ vboxwebsrv -t0
  ```

Once these two are setup, the project is already configured to use the VBox Web Services.

The uberjar will attempt to download it, but more information can be found.


Create the uberjar:

    lein uberjar


Then run it, the Pallet log statements should go to standard out:

    DevBook:target devuser$ java -jar pallet-java-example-0.1.0-SNAPSHOT-standalone.jar
            
    Spinning up example-group virtual machine
    22:02:01.810 [clojure-agent-send-off-pool-0] INFO  pallet.compute.vmfest - This VMFest provider is already configured to use Web Services.
    22:02:01.811 [clojure-agent-send-off-pool-1] INFO  pallet.compute.vmfest.service - No :default-bridged-interface defined. Will chose from these options: en0: Wi-Fi (AirPort)
    22:02:02.655 [clojure-agent-send-off-pool-1] INFO  vmfest.virtualbox.virtualbox - create-machine: Creating machine example-group-0 in /Users/devuser/.vmfest/nodes/vmfest/example-group-0/example-group-0.vbox,  overwriting previous contents
    22:02:19.663 [operate-17] INFO  pallet.ssh.execute - 192.168.56.119 22 os: infer-os:
    22:02:25.657 [operate-17] INFO  pallet.ssh.execute - 192.168.56.119 22 os: infer-distro:
    22:02:26.434 [operate-17] INFO  pallet.ssh.execute - 192.168.56.119 22 [automated-admin-user: install]: package sudo :action :install
    22:02:29.367 [operate-17] INFO  pallet.execute - 192.168.56.119 #> [automated-admin-user: install]: Packages : SUCCESS
    22:02:29.568 [operate-17] INFO  pallet.ssh.execute - 192.168.56.119 22 [automated-admin-user]:
    22:02:30.042 [operate-17] INFO  pallet.ssh.execute - 192.168.56.119 22 automated-admin-user: authorize-user-key: authorize-key:
    22:02:30.321 [operate-17] INFO  pallet.execute - 192.168.56.119 #> automated-admin-user: authorize-user-key: authorize-key: Directory $(getent passwd devuser | cut -d: -f6)/.ssh/ : SUCCESS
    22:02:30.513 [operate-17] INFO  pallet.ssh.execute - 192.168.56.119 22 automated-admin-user: authorize-user-key: authorize-key:
    22:02:30.791 [operate-17] INFO  pallet.execute - 192.168.56.119 #> automated-admin-user: authorize-user-key: authorize-key: file $(getent passwd devuser | cut -d: -f6)/.ssh/authorized_keys : SUCCESS
    22:02:30.974 [operate-17] INFO  pallet.ssh.execute - 192.168.56.119 22 automated-admin-user: authorize-user-key: authorize-key:
    22:02:31.265 [operate-17] INFO  pallet.execute - 192.168.56.119 #> automated-admin-user: authorize-user-key: authorize-key: authorize-key on user devuser (ssh_key.clj:32) :    SUCCESS
    22:02:31.444 [operate-17] INFO  pallet.ssh.execute - 192.168.56.119 22 automated-admin-user: authorize-user-key: authorize-key:
    22:02:31.718 [operate-17] INFO  pallet.execute - 192.168.56.119 #> automated-admin-user: authorize-user-key: authorize-key: Set selinux permissions (ssh_key.clj:37) : SUCCESS
    22:02:31.912 [operate-17] INFO  pallet.ssh.execute - 192.168.56.119 22 automated-admin-user: sudoers: remote-file /etc/sudoers :content "Defaults env_keep=SSH_AUTH_SOCK..."
    22:02:32.201 [operate-17] INFO  pallet.execute - 192.168.56.119 #> automated-admin-user: sudoers: remote-file /etc/sudoers : SUCCESS
    22:02:32.509 [operate-16] INFO  pallet.ssh.execute - 192.168.56.119 22
    22:02:37.911 [operate-16] INFO  pallet.execute - 192.168.56.119 #> file /tmp/phase-configure-basenode : SUCCESS
    Completed VM creation


Note pallet-vmfest uses 192.168.56.x network by default.

## License

Copyright ©  Al Baker

Distributed under the Eclipse Public License.
