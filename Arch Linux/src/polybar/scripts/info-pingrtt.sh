#!/bin/sh

HOST=google.hu

if ! ping=$(ping -n -c 1 -W 1 $HOST); then
    echo " %{F#E06C75}%{F-}  FAILED"
else
    rtt=$(echo "$ping" | sed -rn 's/.*time=([0-9]{1,})\.?[0-9]{0,} ms.*/\1/p')

    if [ "$rtt" -lt 100 ]; then
        icon=" %{F#98C379}%{F-} "
    else
        icon=" %{F#E06C75}%{F-} "
    fi

    echo "$icon $rtt ms"
fi
