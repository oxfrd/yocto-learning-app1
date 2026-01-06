# Base this image on core-image-base
include recipes-core/images/core-image-base.bb

COMPATIBLE_MACHINE = "^rpi$"

ENABLE_UART = "0"

IMAGE_FEATURES:remove = "debug-tweaks splash"
EXTRA_IMAGE_FEATURES:remove = "debug-tweaks"

IMAGE_FEATURES:append = " read-only-rootfs"

inherit extrausers
EXTRA_USERS_PARAMS = "\
    usermod -p '\$6\$31pZKNJQhWZvgDCM\$FBUV8J0JB8iO5BZG4urZyGXXnIoHyGvlf84.WF4yQxHuj9B5TzzOWVYtmM6Bieml6oDhjwUjHWTBTeguNqV7q1' root; \
    "
# to remember change '$ to \$' 
