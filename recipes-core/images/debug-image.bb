# Base this image on core-image-base
include recipes-core/images/core-image-base.bb

COMPATIBLE_MACHINE = "^rpi$"

ENABLE_UART = "1"

# Add primary features
IMAGE_FEATURES:append = " debug-tweaks tools-debug dev-pkgs dbg-pkgs ssh-server-dropbear"
IMAGE_FEATURES:remove = "read-only-rootfs"

# Add packages from recipes
IMAGE_INSTALL:append = " iperf3 htop"

inherit extrausers
EXTRA_USERS_PARAMS = "\
    usermod -p '\$6\$31pZKNJQhWZvgDCM\$FBUV8J0JB8iO5BZG4urZyGXXnIoHyGvlf84.WF4yQxHuj9B5TzzOWVYtmM6Bieml6oDhjwUjHWTBTeguNqV7q1' root; \
    "
# to remember change '$ to \$' 
