blacktoblue
===========

Peer information sharing and reporting

Goal: To allow citizens to communicate and report incidents in intuitive ways, even when internet and telephony has been severed by a repressive regime.

Key Data points: Reports done by Google show that the rates of smartphone adoption in "not free" Middle Eastern nations (UAE, Egypt) is huge, trumping even those in the US.  

So Instead of imposing a new type of communication technology, our aim is to supplement existing social network and chat services with peer-to-peer, serverless and internet-independent redundancies.

Implementation: We wrote an Android application that uses the ubiquitous bluetooth protocol for sharing text and images.

Next steps:
- Integrate with Google+ History API
- Integrate with a general data store (in the event that the regime blocks Google.com)
- Increase robustness with intermittent network (sendEventually methods)
- More "carrying the bucket" for peers : I want to post, but lack a connection, I can hand my posts to a trusted individual (e.g. a journalist) and know that my message will reach the net eventually.
- Photos with EXIF meta data will be streamed on Panoramio to show where the incident occurred 
- Instant encryption of photos/text to protect the user 
- Incorporate "Pirate Boxes" (http://wiki.daviddarts.com/PirateBox) to increase bandwidth and range of evidence

Installation instructions:

1. Please go to the "Downloads" link and download the latest .APK to 2 Android devices

2. Pair them using bluetooth (in future iterations, we can use Android BT methods to get around this barrier)

3. On each device, click the top button to make the device connectable

4. On each device, click the bottom button to search for a connection to the other

5. On each device, you'll see a MAC address of the other device, click on it to connect.

6. Once the text field is white, you can type messages and push to the other phone

7. Double-tap on the text field to select an image