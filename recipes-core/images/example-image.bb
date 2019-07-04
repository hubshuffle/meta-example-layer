# Base this image on core-image-base
include recipes-core/images/core-image-base.bb

# Only allow for machines which start with "rpi"
COMPATIBLE_MACHINE = "^rpi$"

# User configuration
inherit extrausers
EXTRA_USERS_PARAMS = "\
usermod -p \\\$1\\\$8uiksjhr\\\$dGcSUTCMLX0Tl1Benl3SX. root \
"

# Customize hostname
hostname_pn-base-files = "berry"

# Configure timezone
IMAGE_INSTALL += "tzdata-europe tzdata"

# install kernel modules
IMAGE_INSTALL += "kernel-modules"

# Only produce the "rpi-sdimg" image format
IMAGE_FSTYPES = "rpi-sdimg"
# Remove old builds
RM_OLD_IMAGE = "1"

# Customize the splash screen or disable
#SPLASH = "psplash-raspberrypi"
#IMAGE_FEATURES += "splash"
IMAGE_FEATURES_remove = "splash"

# Add ssh
IMAGE_FEATURES += "ssh-server-dropbear"

# Add package management
EXTRA_IMAGE_FEATURES += "package-management"
PACKAGE_CLASSES = "package_rpm"

# Print this message when
do_image_complete_append() {
    bb.warn("The image has been freshly baked!")
}

# Install watchdog
IMAGE_INSTALL += "watchdog"

# Add support for wifi and bluetooth
IMAGE_INSTALL += "linux-firmware linux-firmware-bcm43430"

# Add mount.nfs
IMAGE_INSTALL += "nfs-utils"

# Add our python flask hello world app
IMAGE_INSTALL += "python-flask-hello-world"

# Add cpp hello world app
IMAGE_INSTALL += "cpp-hello-world"

# Use Network Manager
IMAGE_INSTALL += "networkmanager networkmanager-bash-completion networkmanager-nmtui"

# Install i2c-tools
IMAGE_INSTALL += "i2c-tools"

# Install picocom
IMAGE_INSTALL += "picocom"

# Install cmake hello world 
IMAGE_INSTALL += "cmake-hello-world"
