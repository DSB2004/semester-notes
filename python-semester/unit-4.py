# ----------------------------
# Web Scraping in Python 🕷️
# ----------------------------

# ====================================
# 1. MAPIT.PY — Open Google Maps 🌍
# ====================================
import webbrowser, sys, pyperclip

# MapIt.py - Launches a map in the browser using an address from the command line or clipboard.

# Get address from command line or clipboard
if len(sys.argv) > 1:
    address = ' '.join(sys.argv[1:])  # from command line
else:
    address = pyperclip.paste()  # fallback: clipboard
print(address)
# Open the browser with Google Maps and the address
webbrowser.open(f"https://www.google.com/maps/place/{address}")

# This is useful for CLI tools or setting shortcuts in automation
# Example: python mapit.py 221B Baker Street London


# ====================================
# 2. Downloading Files with requests 🌐
# ====================================
import requests

# Download a file from the web
url = "https://imgs.search.brave.com/IUJgLSdJk7gGkiXhsjoevQ4vNnhfh-UgE6s-zuLF3xE/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTA3/MTEwNDczNC9waG90/by93b21hbi1zaWxo/b3VldHRlLWF0LXN1/bnNldC1vbi1oaWxs/LmpwZz9zPTYxMng2/MTImdz0wJms9MjAm/Yz0zUHJDSGNsdFM0/VHR4VVhIeFQ5ckxY/ckcxNTRMcGY3MEJO/RFFma3lzUm5RPQ"
res = requests.get(url)

# Always check for download success
res.raise_for_status()

# ====================================
# 3. Saving Files to Disk 💾
# ====================================
# Save the downloaded file to disk
with open("downloaded_text.png", "wb") as file:
    for chunk in res.iter_content(100000):  # download in chunks
        file.write(chunk)

# Great for saving PDFs, images, datasets, etc.


# ====================================
# 4. Parsing HTML (Basic) 📄
# ====================================
from bs4 import BeautifulSoup

html_doc = """
<html><head><title>Test Page</title></head>
<body>
<h1>Main Heading</h1>
<p class="description">This is a simple HTML document.</p>
<a href="https://example.com">Visit Example</a>
</body></html>
"""

# Parse the HTML
soup = BeautifulSoup(html_doc, "html.parser")

# Extract data from HTML
print("Title:", soup.title.text)
print("Heading:", soup.h1.text)
print("Link href:", soup.a['href'])
print("Description:", soup.p.text)


# ====================================
# Summary 🚀
# ====================================
# - webbrowser: open map links or websites directly
# - requests: fetch content from the web (HTML, files)
# - write(): save anything to disk
# - BeautifulSoup: parse & extract HTML content

# You can now build:
# - Map launching tools
# - File downloaders
# - Web crawlers
# - Article summarizers
